import LsRequest from '../../service/index'// pages/homeV2/index.js
import Dialog from '@vant/weapp/dialog/dialog';
import Toast from '@vant/weapp/toast/toast'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    payData:[],
    finishedData:[]
  },
  goPayBtnClick:function (event) {
    console.log(event);
    const r_id = event.currentTarget.dataset.id
    Dialog.confirm({
      title: '标题',
      message: '您确定购买该课程吗？',
    })
      .then(() => {
        // on confirm
        const user_id = wx.getStorageSync('u_id')
        
        LsRequest.get(`education/order/updateOrder?r_id=${r_id}`)
        this.getNoPayOrders(user_id)
        Toast.success('购买成功~')
        Dialog.close()
   
      })
      .catch(() => {
        // on cancel
        // const user_id = wx.getStorageSync('u_id')
        // LsRequest.get(`education/order/buyCourse?cs_id=${this.data.courseId}&r_status=${0}&user_id=${user_id}`)
        Dialog.close()
      });
    
  },
  deleteOrder:function(event){
    const r_id = event.currentTarget.dataset.id
    Dialog.confirm({
      title: '标题',
      message: '您确定删除该课程吗？',
    })
      .then(() => {
        // on confirm
        const user_id = wx.getStorageSync('u_id')
        LsRequest.delete(`education/order/deleteOrder?r_id=${r_id}`)
        this.getNoPayOrders(user_id)
        Dialog.close()
        Toast.success('删除成功~');
      })
      .catch(() => {
        // on cancel
        // const user_id = wx.getStorageSync('u_id')
        // LsRequest.get(`education/order/buyCourse?cs_id=${this.data.courseId}&r_status=${0}&user_id=${user_id}`)
        Dialog.close()
      });
  },
  getNoPayOrders:function(u_id){
    LsRequest.get(`education/order/showUnFinishOrder?user_id=${u_id}`).then(res=>{
      console.log(res.data);
      this.setData({finishedData:res.data})
    })
  },
  getFinishedOrder:function(u_id){
    LsRequest.get(`education/order/showFinishOrder?user_id=${u_id}`).then(res=>{
      console.log(res.data);
      this.setData({payData:res.data})
    })
  },
  playVideo1: function(item){
   const {r_id} = item.currentTarget.dataset
    wx.navigateTo({
      url: `/pages/video1/index?r_id=` +r_id  ,
    })

},


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // var u_id = wx.getStorageSync("u_id")
 
    // this.getFinishedOrder(u_id)
    // console.log(u_id);
    // this.getNoPayOrders(u_id)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var u_id = wx.getStorageSync("u_id")
 
    this.getFinishedOrder(u_id)
    console.log(u_id);
    this.getNoPayOrders(u_id)
  },


  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})