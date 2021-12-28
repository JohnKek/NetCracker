<template>
  <div>
    <ProductForm :products="products" :productAtr="product"/>
    <ProductRow v-for="product in products" :key="product.id" :product="product"
                :products="products" :editMethod ="editMethod"/>
  </div>
</template>

<script>

import Vue from "vue";
import ProductRow from "@/components/ProductRow";
import ProductForm from "@/components/ProductForm";

export default {

  name: "ProductList",
  props: ['products'],
  data: function () {
    return {
      product: null,
    }
  },
  mounted() {
    this.loadRecipe()
  },
  methods: {
     loadRecipe() {
       /* eslint-disable */
      var productApi = Vue.resource('http://localhost:8080/product');
      productApi.get().then(result =>
          result.json().then(data =>
              data.forEach(product => this.products.push(product))
          )
      )
      /*this.products.forEach(recipe => console.log(recipe.id_recipe))
      console.log(this.products)*/
    },
    editMethod: function (product) {
      this.product = product;
    },

  },
  components: {ProductRow,ProductForm}
}
</script>

<style scoped>

</style>