import service from "@/utils/axios";

export function getAllNews(data){
   return service({
       url:'/management/news/getAllNews',
       method:'POST',
       data
   })
}

export function selectNewsById(data){
    return service({
        url:'/management/news/selectNewsById',
        method:'POST',
        data
    })
 }

 export function addNews(data){
    return service({
        url:'/management/news/addNews',
        method:'POST',
        data
    })
 }

 export function deleteNews(data){
    return service({
        url:'/management/news/deleteNews',
        method:'POST',
        data
    })
 }

 export function updateNews(data){
    return service({
        url:'/management/news/updateNews',
        method:'POST',
        data
    })
 }