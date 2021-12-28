import Vue from "vue";

Vue.component('Card2', {
    props: ['recipe'],
    template: '<h3>{{ recipe }}</h3>'
})
