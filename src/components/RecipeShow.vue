<template>
  <main class="main_block">
    <div class="main_block_container container">
      <div class="main_block_body">
        <div class="recipe_item">
               <img class="recipe_pic" src="" alt="">
         <img width="400px" class="recipe_pic" :src="require(`../assets/${info.recipe_img_path}`)" alt="">
          <div class="recipe_time">
            <div class="time_pic"></div>
            <div class="time_text">{{ info.recipe_time }} минут</div>
          </div>
          <div class="recipe_name">{{ info.recipe_name }}</div>
        </div>
        <div class="ingridient_block">
          <div class="cook_title">Ингредиенты</div>
          <ul class="ingridient_list">

            <li class="ingridient_item">Стейк «Нью-Йорк» Праймбиф — 800 г</li>
            <li class="ingridient_item">Оливковое масло — 3 ст.л.</li>
            <li class="ingridient_item">Смесь перцев — по вкусу</li>
            <li class="ingridient_item">Соль — по вкусу</li>
            <li class="ingridient_item">Другие приправы (базилик / розмарин / тимьян) — по вкусу</li>
            <li>{{ ImgUrl }}</li>
          </ul>
        </div>
        <div class="cook_desk_block">
          <div class="cook_title">Способ приготовления</div>
          {{ info.recipe_desc }}
        </div>
      </div>
    </div>
  </main>
</template>

<script>


import axios from "axios";

export default {
  name: "RecipeShow",
  data() {
    return {
      idRep: null,
      recipe: null,
      info: null,
      ImgUrl: null,
      test: 'logo'

    }
  },
  mounted() {
    this.load()

  },
  methods: {
    load() {
      let id = this.$route.params.id
      var url = 'http://localhost:8080/recipe/'
      url = url + id
      axios
          .get(url)
          .then(response => (this.info = response.data));
    },
    created() {
    }
  }
}
</script>

<!--
<style lang="css">
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
  border-bottom: 1px solid #287BA6;
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
  z-index: 2;
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
  left: -100%;
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

.header_logo {
  width: 96px;
  height: 55px;
  text-align: center;
  background: url(../../../../OneDrive/Desktop/MainPageSite/images/logo.png) 0 0/ 100% auto no-repeat;
  z-index: 2;
}

.header_profile {
  background: url(../../../../OneDrive/Desktop/MainPageSite/images/icons/account.png) 0 0/ 100% auto no-repeat;
  width: 30px;
  height: 30px;
  z-index: 2;
}

/******************MAIN***************************/

.main_block_body {
  margin: 80px 0px 0px 0px;
  padding: 50px 0px 100px 0px;
  width: 100%;
}

.recipe_author {
  font-size: 16px;
  font-weight: 300;
  margin: 0px 0px 10px 0px;
}

.recipe_item {
  position: relative;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  background-color: #0f0f0f;
  border-radius: 20px;
  height: 400px;
}

.recipe_pic {
  width: 100%;
  opacity: 0.7;
  margin: -200px 0px 0px 0px;

}

.recipe_time {
  position: absolute;
  display: flex;
  align-items: center;
  right: 0px;
  margin: 30px;
}

.time_pic {
  background: url(../../../../OneDrive/Desktop/MainPageSite/images/icons/time.png) 0 0/ auto 100% no-repeat;
  width: 20px;
  height: 20px;
  margin: 0px 5px 0px 0px;
}

.time_text {
  font-size: 12px;
  font-weight: 300;
  color: #fff;
}

.recipe_name {
  position: absolute;
  font-size: 60px;
  color: #fff;
  font-weight: 600;
  bottom: 0px;
  margin: 30px;
}

.ingridient_block {
  margin: 40px 0px 40px 0px;
  width: 700px;
}

.cook_title {
  font-size: 22px;
  font-weight: 600;
  color: #666666;
  text-transform: uppercase;
  margin: 0px 0px 15px 0px;
}

.ingridient_list {
  list-style-type: circle;
  margin: 0px 20px 0px 0px;
}

.ingridient_list > *:not(:last-child) {
  margin: 0px 0px 10px 0px;
}

.ingridient_item {
  line-height: 130%;
  font-size: 16px;
  font-weight: 300;
}

.cook_desk_block {
  width: 700px;
}

.cook_step_list {
  list-style-type: decimal;
  margin: 0px 20px 0px 0px;
}

.cook_step_list > *:not(:last-child) {
  margin: 0px 0px 20px 0px;
}

.step_item {
  line-height: 140%;
  font-size: 16px;
  font-weight: 300;
}

.step_item::marker {
  margin: 0px 16px 0px 0px;
}
</style>-->
