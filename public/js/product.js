function getIndex(list, id) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}

var productApi = Vue.resource('http://localhost:8080/product{/id}');



Vue.component('product-form', {
    props: ['products', 'productAtr', 'keyV'],
    data: function () {
        return {
            name: '',
            calories: '',
            proteins: '',
            fats: '',
            carbonydrates: '',
            id: 0,
            formData: null
        }
    },
    watch: {
        productAtr: function (newVal, oldVal) {
            this.name = newVal.name ,
                this.calories = newVal.calories ,
                this.proteins = newVal.proteins ,
                this.fats = newVal.fats ,
                this.carbonydrates = newVal.carbonydrates,
                this.id = newVal.id
        }
    },

    template: '<div>' +
        '<input type="text" placeholder="Название продукта" v-model="name"/>' +
        '<input type="text" placeholder="Калории" v-model="calories"/>' +
        '<input type="text" placeholder="Белки" v-model="proteins"/>' +
        '<input type="text" placeholder="Жиры" v-model="fats"/>' +
        '<input type="text" placeholder="Углеводы" v-model="carbonydrates"/>' +
        '<input type="button" value="Сохранить" :disabled="name.length==0" @click="save"/>' +
        '</div>',
    methods: {
        save: function () {
            var product = {
                id: this.id,
                name: this.name,
                calories: this.calories,
                proteins: this.proteins,
                fats: this.fats,
                carbonydrates: this.carbonydrates
            };
            if (this.id != 0) {
                console.log('putmet')
                this.$http.put('http://localhost:8080/product/45', product).then(response => {
                    console.log(response.body)
                    /*this.products[this.id] = response.body*/
                    this.products[getIndex(this.products, this.id)] = response.body
                    console.log(this.products)

                    window.location.reload()
                });

            } else {
                console.log('save')
                productApi.save({}, product).then(result =>
                    result.json().then(data => {
                        this.products.push(data);
                        this.name = ''
                        this.calories = '',
                            this.proteins = '',
                            this.fats = '',
                            this.carbonydrates = ''
                    })
                )
            }

        },
        load: function () {
            productApi.get().then(result =>
                result.json().then(data =>
                    data.forEach(product => this.products.push(product))
                )
            )
        }

    }
});


Vue.component('product-row', {
    props: ['product', 'editMethod', 'products', 'keyV'],
    template: '<div><i>' +
        '({{product.id}})</i> ' +
        '{{product.name}} ' +
        '{{product.calories}} ' +
        '{{product.proteins}} ' +
        '{{product.fats}} ' +
        '{{product.carbonydrates}}  ' +
        '<span style="position: absolute;right: 0">' +
        '<input type="button" value="Изменить" @click="edit"></input>' +
        '<input type="button" value="Удалить" @click="del"></input>' +
        '</span>' +
        '</div>',
    methods: {
        edit: function () {
            this.editMethod(this.product)
        },
        del: function () {
            productApi.remove({id: this.product.id}).then(result => {
                if (result.ok) {
                    this.products.splice(this.products.indexOf(this.product), 1)
                }
            })
        }
    }
});

Vue.component('productslist', {
    props: ['products', 'keyV'],
    data: function () {
        return {
            product: null,

        }
    },
    template: '<div style="position: relative;width:400px;">' +
        '<product-form :products="products" :productAtr="product" :keyV="keyV"/>' +
        '<product-row v-for="product in products" :key="product.id" :product="product"  ' +
        ':editMethod ="editMethod" :products="products"  :keyV="keyV"/></div>',
    created: function () {
        productApi.get().then(result =>
            result.json().then(data =>
                data.forEach(product => this.products.push(product))
            )
        )
    },

    methods: {
        editMethod: function (product) {
            this.product = product;
        },
        updateList: function () {
            this.$forceUpdate();
        }
    }

});




