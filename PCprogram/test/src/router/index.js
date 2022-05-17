import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
{
  path:"/",
  redirect:'/login'
},
{
  path:'/login',
  component:()=>import('../views/login')
},
{
  path: '/home',
  name: 'home',
  component: ()=>import('@/layout'),
  redirect:'/home/ClassList',
  children:[
    {
      path:"ClassList",
      component:()=> import('@/views/home/ClassList')
    },
    {
      path:"TecherList",
      component:()=> import('@/views/home/TecherList')
    },
    {
      path:"OrderList",
      component:()=> import('@/views/home/OrderList')
    },
    {
      path:"UserList",
      component:()=> import('@/views/home/UserList')
    },
    {
      path:"CommentList",
      component:()=> import('@/views/home/CommentList')
    },
    {
      path:"NewsList",
      component:()=> import('@/views/home/NewsList')
    }
  ]
}
]

const router = new VueRouter({
  routes
})

export default router
