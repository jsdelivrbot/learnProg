import { expect } from "../test_helper";
import commentReducer from "../../src/reducers/comments";
import { SAVE_COMMENT } from "../../src/actions/types";

describe('Comments Reducer', () => {
  it('handles action with unknown type', () => {
    // this expect just asserts that it's of type Array
    // expect(commentReducer()).to.be.an.instanceof(Array);

    // .eql we'll do a deep comparison, all values of the array should be equal
    // .equal checks to see if the array, or whatever is compared, is the absolute identical object
    expect(commentReducer(undefined, {})).to.eql([]);
  });

  it('SAVE_COMMENT', () => {
    const action = { type: SAVE_COMMENT, payload: 'new comment' };
    expect(commentReducer([], action)).to.eql(['new comment']);
  });
});