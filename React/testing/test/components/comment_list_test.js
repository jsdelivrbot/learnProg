import { renderComponent, expect } from "../test_helper";
import CommentList from "../../src/components/comment_list";

describe('Comment List', () => {
  let component;

  beforeEach(() => {
    const state = { comments: ['New Comment', 'Other Comment'] };
    component = renderComponent(CommentList, null, state);
  });

  it('show an li for each comment', () => {
    expect(component.find('li').length).to.equal(2);
  });

  it('show each comment that is provided', () => {
    expect(component).to.contain('New Comment');
    expect(component).to.contain('Other Comment');
  });
});