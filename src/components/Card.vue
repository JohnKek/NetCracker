<template>
  <router-link :to="{name: 'recipePage',params:{id: recipe.id_recipe}}"><div>
  <img width="400px" class="recipe_pic" :src="require(`../assets/${idRep}`)" alt="">
  <div class="recipe_description">
  <div class="recipe_name">{{ recipe.recipe_name }}</div>
  <div class="recipe_time">
    <div class="time_pic"></div>
    <div class="time_text">{{ recipe.recipe_time }} минуты</div>
  </div>
  </div>
  </div></router-link>
</template>

<script>
export default {
  data(){
    return{
idRep:null
    }
  },
  mounted() {
    this.idRep=this.recipe.recipe_img_path.replace(/"/g,'')
  },
  name: "Card",
  /*props:['recipe'],*/
  props:{
    recipe:{
      type:Object,
      required: true
    }
  }
}
</script>

