import service from "@/utils/axios";

export function getAllUser(data){
   return service({
       url:'/management/user/selectAllUser',
       method:'POST',
       data
   })
}