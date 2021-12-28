<template>
 <div>
  <main class="main_block">
        <ProductList class="list" :products="products"/>
  </main>
 </div>
</template>

<script>
import ProductList from "@/components/ProductList";

export default {
  name: "products",
  data() {
    return {
      products: []
    }
  },
components: {ProductList}
}
</script>

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
  left:0px;
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
.header_logo {
  width: 96px;
  height: 55px;
  text-align: center;
  /*background: url(../images/logo.png) 0 0/ 100% auto no-repeat;*/
  z-index: 2;
}
.right_icons {
  display: flex;
  align-items: center;
}
.header_profile {
  /*background: url(../images/icons/account.png) 0 0/ 100% auto no-repeat;*/
  width: 30px;
  height: 30px;
  z-index: 2;
}
/*************************MAIN**********************/

.main_block {
  padding: 100px 0px 100px 0px;
}
.form {
  max-width: 600px;
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
  width: 400px;
  font-size: 16px;
  border: none;
  border: 1px solid #999999;
  border-radius: 5px;
  padding: 5px;
  transition: .3s box-shadow ease;
}
.form_input:focus {
  box-shadow: 0px 0px 12px #a5d1e8;
}
.button_block {
  display: flex;
  justify-content: center;
  align-items: center;
}
.button_block > *:not(:last-child) {
  margin: 0px 15px 0px 0px;
}
.form_button {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 50px;
  min-width: 200px;
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
  width: 600px;
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
</style>