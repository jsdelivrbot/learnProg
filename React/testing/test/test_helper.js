import jsdom from 'jsdom';

// set up testing environment to run like a browser in the command line
global.document = jsdom.jsdom('<!doctype html><html><body></body></html>');
global.window = global.document.defaultView;

// build renderComponent helper that should render a given react class

// build helper for simulating events

// set up chai-jquery