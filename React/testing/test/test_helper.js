import jsdom from 'jsdom';
import jquery from 'jquery';
import TestUtils from 'react-addons-test-utils';
import ReactDOM from 'react-dom';
import chai, { expect } from 'chai';
import React from 'react';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import reducers from '../src/reducers';
import chaiJquery from 'chai-jquery';

// Set up testing environment to run like a browser in the command line
global.document = jsdom.jsdom('<!doctype html><html><body></body></html>');
global.window = global.document.defaultView;
// tell jquery not to try to reach out the dom and to be responsible just of that piece of dome just created.
// From here on out, everywhere else where we need to use jquery in the testing setup we are going to use this modified version of jquery ($)
const $ = jquery(global.window);

// Build renderComponent helper that should render a given react class
function renderComponent(ComponentClass, props, state) {
  // render element into a document
  const componentInstance = TestUtils.renderIntoDocument(
    <Provider store={createStore(reducers, state)}>
      <ComponentClass {...props} />
    </Provider>
  );

  // use ReactDOM to get a reference to the HTML our component produces
  // wrap that with the jquery element so we can get access to all those helpful matchers from jquery chai
  return $(ReactDOM.findDOMNode(componentInstance));
}

// Build helper for simulating events
$.fn.simulate = function(eventName, value) {
  if(value) {
    this.val(value);
  }
  TestUtils.Simulate[eventName](this[0]);
};

// Set up chai-jquery
chaiJquery(chai, chai.util, $);

export { renderComponent, expect };