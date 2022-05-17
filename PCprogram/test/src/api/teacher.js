import service from "@/utils/axios";

export function getAllTeacher(data){
   return service({
       url:'/management/teacher/selectAllTeacher',
       method:'POST',
       data
   })
}

export function addTeacher(data){
    return service({
        url:'/management/teacher/addTeacher',
        method:'POST',
        data
    })
 }

 export function updateTeacher(data){
    return service({
        url:'/management/teacher/updateTeacher',
        method:'POST',
        data
    })
 }

 export function selectTeacherById(data){
    return service({
        url:'/management/teacher/selectTeacher',
        method:'POST',
        data
    })
 }

 export function teacherOption(data){
    return service({
        url:'/management/teacher/teacherOption',
        method:'POST',
        data
    })
 }