// Require the built in 'assertion' library
var assert = require('assert');

// Create a group of tests about Arrays
describe('Array', function() {
  // Within our Array group, Create a group of tests for indexOf
  describe('#indexOf()', function() {
    // A string explanation of what we're testing
    it('should return -1 when the value is not present', function(){
      // Our actual test: -1 should equal indexOf(...)
      assert.equal(-1, [1,2,3].indexOf(4));
    });
  });
});

describe('Math', function() {
  it('should return 9 when multiplying 3*3', function() {
    assert.equal(9, 3*3);
  });

  it('should return -8 when calculating (3-4)*8', function() {
    assert.equal(-8, (3-4)*8);
  });
});