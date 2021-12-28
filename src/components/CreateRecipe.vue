<template>
  <main class="main_block">
    <div class="main_block_container container">
      <div class="form">
        <form action="#" id="form">
          <h1 class="form_title">Рецепт</h1>
          <div class="upper_block">
            <div class="form_item">
              <label for="formName" class="form_label">Название рецепта</label>

              <input id="formName" type="text" class="form_input" v-model="name"/>

            </div>
            <div class="form_item">
              <label for="formTime" class="form_label">Время приготовления</label>
              <input id="formTime" type="text" class="form_input" v-model="time"/>
            </div>
          </div>

          <div class="form_item">
            <lable for="formComment" class="form_label">Описание</lable>
            <textarea id="formComment" class="form_description" v-model="desc"/>
          </div>
          <font color="red"><h1 v-if="this.file==''">Выберите файл</h1></font>
          <div class="button_block">
            <input type="file" ref="uploadImage" @change="onImageUpload()" class="form-control" required>
            <input type="button" @click="startupload" name="Upload" value="Accept">
          </div>

          <div class="add_prod_block">
            <div class="form_item">
              <label for="formProduct" class="form_label">Продукт</label>
              <input id="formProduct" type="text" class="form_input" v-model="product">
            </div>
            <div class="form_item">
              <label for="formWeight" class="form_label">Вес</label>
              <input id="formWeight" type="text" class="form_input" v-model="weight">
            </div>
            <div class="button_block">
              <input type="button" class="form_button" @click="addIngridient" value="Добавить" :disabled="product==null||product==''"/>
            </div>
          </div>

          <ul class="list">
            <li class="list_item" v-for="ingridient in Ingridients" :key="ingridient.product">
              <div class="list_text"><span class="list_name">{{ ingridient.product }}</span>{{ ingridient.weight }} г/шт
              </div>
              <div class="button_block">
                <button type="submit" class="btn" @click="deletefromIngridient(ingridient.product)">Удалить</button>
              </div>
            </li>
          </ul>

          <!--          <div class="add_tag_block">
                      <div class="form_item">
                        <label for="formTag" class="form_label">Тэг</label>
                        <input id="formTag" type="text" class="form_input">
                      </div>
                      <div class="button_block">
                        <button type="submit" class="form_button">Добавить</button>
                      </div>
                    </div>-->

          <!--          <ul class="list">
                      <li class="list_item">
                        <div class="list_text"><span class="list_name">Вкусный завтрак</span>
                        </div>
                        <div class="button_block">
                          <button type="submit" class="btn">Удалить</button>
                          <button type="submit" class="btn">Редактировать</button>
                        </div>
                      </li>
                      <li class="list_item">
                        <div class="list_text"><span class="list_name">Каша</span>
                        </div>
                        <div class="button_block">
                          <button type="submit" class="btn">Удалить</button>
                          <button type="submit" class="btn">Редактировать</button>
                        </div>
                      </li>
                    </ul>-->
          <div class="button_block">
            <input type="button" class="form_button" :disabled="name.length!=0&&this.file!=null" @click="save" value="Сохранить"/>

          </div>
        </form>
      </div>

    </div>

  </main>
</template>

<script>
import Vue from "vue";
import axios from "axios";

export default {
  name: "CreateRecipe",
  data: function () {
    return {
      id: null,
      name: '',
      time: '',
      desc: '',
      file: '',
      product: null,
      weight: null,
      Ingridients: [],
      status: 0,
      test: null,
      ingridientList: [],
      Recipe: null,
      urlSave: 'kal',
    }
  },
  methods: {
    getIndexId(list, id) {
      for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
          return i;
        }
      }
      return -1;
    },
    getIndexName(list, name) {
      for (var i = 0; i < list.length; i++) {
        if (list[i].product === name) {
          return i;
        }
      }
      return -1;
    },
    deletefromIngridient(name) {
      let id = this.getIndexName(this.Ingridients, name)
      this.Ingridients.splice(id, 1)
      this.ingridientList.splice(id, 1)
    },
    async save() {
      var recipeApi = Vue.resource('http://localhost:8080/recipe/');
      var recipe = {
        recipe_name: this.name,
        recipe_time: this.time,
        recipe_desc: this.desc,
        recipe_img_path: this.file,
      }
      recipeApi.save({}, recipe).then(result =>
          result.json().then(data => {
            console.log(data),
                console.log(result.body + '1'),
                console.log(this.urlSave),
                this.name = '',
                this.time = '',
                this.desc = ''
            this.addIngridients2(result.body)
          })
      )

    },
    onImageUpload() {
      let file = this.$refs.uploadImage.files[0];
      this.formData = new FormData();
      this.formData.append("file", file);
    },
    startupload() {
      axios({
        url: 'http://localhost:8080/recipe/upload',
        method: 'POST',
        data: this.formData,
        headers: {
          Accept: 'application/json',
          'Content-Type': 'multipart/form-data'
        },
      }).then(response => {
        console.log(JSON.stringify(response.data));
        this.file = JSON.stringify(response.data).replace(/"/g, '')
        console.log(this.file)

      });
    },
    addIngridient() {
      var ingridient = {
        product: this.product,
        weight: this.weight
      }

      this.Ingridients.push(ingridient)
      console.log(this.Ingridients)
      this.product = ''
      this.weight = ''
    },
    addIngridients2(id) {
      this.linkId=id
      for (let i = 0; i < this.Ingridients.length; i++) {
        console.log(this.Ingridients[i].product)
        var url = 'http://localhost:8080/product/name/' + this.Ingridients[i].product
        var url2 = 'http://localhost:8080/product/ingNew/' + this.Ingridients[i].weight
        var url3 = 'http://localhost:8080/recipe/ingrid/' + id
        console.log(url3)
        var recipeApi = Vue.resource(url2);
        var ingridApi = Vue.resource(url3);
        axios
            .get(url)
            .then(response => (
                recipeApi.save({}, response.data).then(result => (
                    ingridApi.save({},result.data),
                        console.log(result.body)
                ))
            ));
      }
      console.log(id)
    }
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
}

body {
  font-family: 'Montserrat', sans-serif;
  background-color: #fff;
  color: #000;
  font-size: 14px;
  font-weight: 400;
}

a {
  text-decoration: none;
}

.wrapper {
  display: flex;
  flex-direction: column;
  overflow: hidden;
  min-height: 100%;
}

.container {
  max-width: 1100px;
  padding: 0px 20px;
  margin: 0px auto;
  box-sizing: content-box;
}


/******************HEADER********************/

.header {
  position: fixed;
  width: 100%;
  left: 0;
  top: 0;
  z-index: 50;
  border-bottom: 1px solid #999999;
}

.header::before {
  content: "";
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background-color: #fff;
  opacity: 0.8;
  /*z-index: 1;*/
}

.header_container {
  position: relative;
  display: flex;
  justify-content: space-between;
  max-width: 100%;
  min-height: 80px;
  align-items: center;
}

.header_menu_burger {
  position: relative;
  width: 30px;
  height: 17px;
  z-index: 30;
}

.header_menu_burger::before {
  top: 0px;
}

.header_menu_burger::after {
  bottom: 0px;
}

.header_menu_burger::before, .header_menu_burger::after {
  content: "";
  background-color: #666666;
  position: absolute;
  width: 100%;
  height: 1px;
  left: 0px;
  transition: all .3s ease;
}

.header_menu_burger span {
  position: absolute;
  left: 0px;
  width: 100%;
  height: 1px;
  top: 8px;
  background-color: #666666;
}

.header_menu_burger.active::before {
  transform: rotate(-37deg);
  width: 40%;
  top: 4px;
}

.header_menu_burger.active::after {
  transform: rotate(37deg);
  width: 40%;
  bottom: 4px;
}

body.lock {
  overflow: hidden;
}

.header_menu {
  position: fixed;
  width: 350px;
  height: 100%;
  top: 0px;
  left: -1000%;
  overflow: auto;
  opacity: 1;
  background-color: #d9effa;
  padding: 80px 0px 0px 0px;
  transition: all .3s ease;
  z-index: 2;
}

.header_menu.active {
  left: 0px;
}

.menu_list {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  z-index: 2;
}

.menu_item {
  width: 100%;
  border-top: 1px solid #a5d1e8;
  padding: 7px 15px;
  transition: .3s background-color ease;
}

.menu_item:last-child {
  border-bottom: 1px solid #a5d1e8;
}

.menu_item:hover {
  background-color: #bbdef0;
}

.menu_link {
  color: inherit;
  line-height: 171%;
  font-size: 16px;
  transition: opacity .1s linear;
}

.right_icons {
  display: flex;
  align-items: center;
}

/*************************MAIN**********************/

.main_block {
  padding: 100px 0px 100px 0px;
}

.form {
  width: 1100px;
  padding: 50px 0px 0px 0px;
  margin: 0px auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form * {
  outline: none;
}

.form_title {
  font-size: 40px;
  font-weight: 700;
  text-align: center;
  margin: 0px 0px 25px 0px;
}

.upper_block {
  display: flex;
}

.upper_block > *:not(:last-child) {
  margin: 0px 100px 0px 0px;
}

.form_item {
  margin: 0px 0px 20px 0px;
}

.form_label {
  display: block;
  font-size: 16px;
  margin: 0px 0px 5px 0px;
}

.form_input {
  height: 40px;
  width: 250px;
  font-size: 16px;
  font-family: 'Montserrat', sans-serif;
  letter-spacing: 1px;
  border: none;
  border: 1px solid #999999;
  border-radius: 5px;
  padding: 5px 10px;
  transition: .3s box-shadow ease;
}

.form_input:focus {
  box-shadow: 0px 0px 12px #a5d1e8;
}

.form_description {
  width: 100%;
  height: 250px;
  resize: none;
  border: none;
  font-size: 16px;
  font-family: 'Montserrat', sans-serif;
  letter-spacing: 1px;
  border: 1px solid #999999;
  border-radius: 5px;
  padding: 15px;
  transition: .3s box-shadow ease;
}

.button_block {
  display: flex;
  align-items: center;
}

.button_block > *:not(:last-child) {
  margin: 0px 15px 0px 0px;
}

.form_button {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px 20px;
  background-color: #a5d1e8;
  color: #fff;
  font-weight: 700;
  font-size: 18px;
  letter-spacing: 1px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: .2s background-color ease;
}

.form_button:hover {
  background-color: #d9effa;
}

.add_prod_block {
  padding: 30px 0px 0px 0px;
  display: flex;
  align-items: flex-end;
}

.add_prod_block > *:not(:last-child) {
  margin: 0px 20px 0px 0px;
}

.list {
  margin: 40px 0px 0px 0px;
}

.list_item {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  font-size: 16px;
  max-width: 100%;
  margin: 0px 0px 20px 0px;
}

.list_text {
  margin: 0px 30px 0px 0px;
  width: 300px;
  font-weight: 300;
}

.list_name {
  font-size: 20px;
  text-transform: uppercase;
  font-weight: 600;
  color: #6da1c9;
  margin: 0px 15px 0px 0px;
}

.btn {
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0px 25px;
  background-color: #fff;
  color: #6da1c9;
  font-weight: 700;
  font-size: 16px;
  letter-spacing: 1px;
  border: none;
  border: 2px solid #6da1c9;
  border-radius: 20px;
  cursor: pointer;
}

.add_tag_block {
  padding: 30px 0px 0px 0px;
  display: flex;
  align-items: flex-end;
}

.add_tag_block > *:not(:last-child) {
  margin: 0px 20px 0px 0px;
}
</style>