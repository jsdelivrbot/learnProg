import jsdom from 'jsdom';
import jquery from 'jquery';

// set up testing environment to run like a browser in the command line
global.document = jsdom.jsdom('<!doctype html><html><body></body></html>');
global.window = global.document.defaultView;
// tell jquery not to try to reach out the dom and to be responsible just of that piece of dome just created.
// From here on out, everywhere else where we need to use jquery in the testing setup we are going to use this modified version of jquery ($)
const $ = jquery(global.window);

// build renderComponent helper that should render a given react class

// build helper for simulating events

// set up chai-jquery