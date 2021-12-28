<template>
  <div class="form">
    <form action="#" id="form" class="form_body">
      <h1 class="form_title">Продукт</h1>

      <div class="form_item">
        <label for="formName" class="form_label">Название продукта</label>
        <input id="formName" type="text" class="form_input" v-model="name">
      </div>
      <div class="form_item">
        <label for="formProtein" class="form_label">Белки</label>
        <input id="formProtein" type="text" class="form_input" v-model="proteins">
      </div>
      <div class="form_item">
        <label for="formFats" class="form_label">Жиры</label>
        <input id="formFats" type="text" class="form_input" v-model="fats">
      </div>
      <div class="form_item">
        <label for="formCarbohydrates" class="form_label">Углеводы</label>
        <input id="formCarbohydrates" type="text" class="form_input" v-model="carbonydrates">
      </div>
      <div class="form_item">
        <label for="formCalories" class="form_label">Калории</label>
        <input id="formCalories" type="text" class="form_input" v-model="calories">
      </div>
      <div class="button_block">
        <input type="button" class="form_button" :disabled="name.length==0" @click="save"/>
      </div>
    </form>

  </div>
</template>

<script>
import Vue from "vue";

export default {
  name: "ProductForm",
  props: ['products', 'productAtr'],
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
    productAtr: function (newVal) {
      this.name = newVal.name ,
          this.calories = newVal.calories ,
          this.proteins = newVal.proteins ,
          this.fats = newVal.fats ,
          this.carbonydrates = newVal.carbonydrates,
          this.id = newVal.id
    }
  },
  methods: {
    getIndex(list, id) {
      for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
          return i;
        }
      }
      return -1;
    },
    save: function () {
      /* eslint-disable */
      var productApi = Vue.resource('http://localhost:8080/product');

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
        var url='http://localhost:8080/product/45'+this.id
        this.$http.put(url, product).then(response => {
          console.log(response.body)
          /*this.products[this.id] = response.body*/
          this.products[this.getIndex(this.products, this.id)] = response.body
          console.log(this.products)

          window.location.reload()
        });

      } else {
        console.log('save')
        productApi.save({}, product).then(result =>
            result.json().then(data => {
              /*this.products.push(data);*/
              console.log(data)
              this.name = ''
              this.calories = '',
                  this.proteins = '',
                  this.fats = '',
                  this.carbonydrates = ''
            })
        )
        window.location.reload()
      }
    }
  }

}
</script>

<style scoped>

</style>