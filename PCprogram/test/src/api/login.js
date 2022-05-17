import service from "@/utils/axios";

export function Login(data){
   return service({
       url:'/management/user/login',
       method:'POST',
       data
   })
}