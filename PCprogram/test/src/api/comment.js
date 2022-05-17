import service from "@/utils/axios";

export function getAllCommentList(data){
   return service({
       url:'/management/comment/selectAllComment',
       method:'POST',
       data
   })
}

export function deleteCommentList(data){
    return service({
        url:'/management/comment/deleteComment',
        method:'POST',
        data
    })
 }