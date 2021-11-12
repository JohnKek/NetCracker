new Vue({
    el: '#recipe',
    data() {
        return {
            info: null
        };
    },


    mounted() {
        axios
            .get('recipe/6/showIngridients')
            .then(response => (this.info = response.data));
    }
});

