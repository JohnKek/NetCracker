import VueRouter from "vue-router";
import RecipeShow from "@/components/RecipeShow";
import RecipeList from "@/components/RecipeList";
import products from "@/components/products";
import CreateRecipe from "@/components/CreateRecipe";
export default new VueRouter({
    routes: [
        {
            path: '/',
            name:'main',
            component: RecipeList
        },
        {
            path: '/recipe',
            name:'recipe',
            component: RecipeShow
        },
        {
            path: '/recipe/:id',
            name:'recipePage',
            component: RecipeShow
        },
        {
            path: '/products',
            name:'products',
            component: products
        },
        {
            path:'/CreateRecipe',
            name:'CreateRecioe',
            component: CreateRecipe
        }

    ]
})