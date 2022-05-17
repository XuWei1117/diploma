import service from "@/utils/axios";

export function getAllOrderList(data){
   return service({
       url:'/management/order/orderList',
       method:'POST',
       data
   })
}
export function deleteOrder(data){
    return service({
        url:'/management/order/deleteOrder',
        method:'POST',
        data
    })
 }
 export function payOrder(data){
    return service({
        url:'/management/order/payOrder',
        method:'POST',
        data
    })
 }