import service from "@/utils/axios";

export function getAllCourseList(data){
   return service({
       url:'/management/course/showCourseList',
       method:'POST',
       data
   })
}

export function addCourse(data){
    return service({
        url:'/management/course/addCourse',
        method:'POST',
        data
    })
 }

 export function getCourseDetail(data){
    return service({
        url:'/management/course/courseDetail',
        method:'POST',
        data
    })
 }

 export function updateCourse(data){
    return service({
        url:'/management/course/updateCourse',
        method:'POST',
        data
    })
 }

 export function deleteCourse(data){
    return service({
        url:'/management/course/deleteCourse',
        method:'POST',
        data
    })
 }

 