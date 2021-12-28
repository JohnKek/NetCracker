<template>
<!--  <div class="list_text">
  <i>({{product.id}})</i>
  {{product.name}}
  {{product.calories}}
  {{product.proteins}}
  {{product.fats}}
  {{product.carbonydrates}}</div>-->
  <li class="list_item">
  <div class="list_text"><span class="list_name">{{product.name}}</span>{{product.proteins}}гр - белки, {{product.fats}}гр - жиры, {{product.carbonydrates}}гр - углеводы, {{product.calories}}ккал</div>
    <div class="button_block">
      <input class="btn" type="button" value="Изменить" @click="edit"/>
      <input class="btn" type="button" value="Удалить" @click="del"/>
    </div>
  </li>
</template>

<script>


import Vue from "vue";

export default {
  props: ['product', 'editMethod', 'products'],
  name: "ProductRow",
  methods: {
    edit: function () {
      /* eslint-disable */
      this.editMethod(this.product)
    },
    del: function (id) {
      var productApi = Vue.resource('http://localhost:8080/product{/id}');
      productApi.remove({id: this.product.id}).then(result => {
        if (result.ok) {
          this.products.splice(this.products.indexOf(this.product), 1)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>