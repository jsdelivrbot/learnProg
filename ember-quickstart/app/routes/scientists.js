import Route from '@ember/routing/route';

export default Route.extend({
  model() {
    return ['Carl', 'Albert', 'Hofmann'];
  }
});
