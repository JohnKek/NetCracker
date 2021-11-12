new Vue({
    el: '#app',
    data() {
        return {
            info: null
        };
    },


    mounted() {
        axios
            .get('api/employees')
            .then(response => (this.info = response.data));
    }
});

