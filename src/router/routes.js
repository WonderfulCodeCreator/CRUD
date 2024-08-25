// 引入需要跳转的组件
import Home from '@/pages/Home'
import Search from '@/pages/Search'
import Register from '@/pages/Register'
import Login from '@/pages/Login'

/*
// 配置路由映射关系
*/
export default [
    {
        path: '/',
        component: Home
    },
    {
        path: '/search',
        component: Search
    },
    {
        path: '/register',
        component: Register
    },
    {
        path: '/login',
        component: Login
    }
]