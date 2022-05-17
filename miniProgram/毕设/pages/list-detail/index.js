// pages/list-detail/index.js
import LsRequest from '../../service/index'
import Toast from '@vant/weapp/toast/toast'
import Dialog from '@vant/weapp/dialog/dialog';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active: 0,
    courseId:'',
    pageListDetailData:{},
    show: false,
    noMore:false,
    pinglun:[],
    inputPingLun:''

  },
  handleBuyBtnClick:function () {
    Dialog.confirm({
      title: '标题',
      message: '您确定购买该课程吗？',
    })
      .then(() => {
        var r_img = this.data.pageListDetailData.order_img
        // on confirm
        const user_id = wx.getStorageSync('u_id')
        LsRequest.get(`education/order/buyCourse?cs_id=${this.data.courseId}&r_status=${1}&user_id=${user_id}`).then(res=>{
          if(res.data.code === '200'){
            Toast.success('购买成功~');
          }else{
            Toast.fail('购买失败!');
          
          }
        })
        this.getFinishedOrder(user_id)
        
        Dialog.close()

     
      })
      .catch(() => {
        // on cancel
        const user_id = wx.getStorageSync('u_id')
        LsRequest.get(`education/order/buyCourse?cs_id=${this.data.courseId}&r_status=${0}&user_id=${user_id}`)
    
        this.getNoPayOrders(user_id)
        Dialog.close()
      });
   
  },



  getNoPayOrders:function(u_id){
    LsRequest.get(`education/order/showUnFinishOrder?user_id=${u_id}`).then(res=>{
      console.log(res);
    })
  },
  getFinishedOrder:function(u_id){
    LsRequest.get(`education/order/showFinishOrder?user_id=${u_id}`).then(res=>{
    })
  },
  onChange(event) {
    // event.detail 的值为当前选中项的索引
    this.setData({ active: event.detail });
  },
  showPopup() {
    this.setData({ show: true });
  },

  onClose() {
    this.setData({ show: false });
  },
  //获取到课程详情信息显示在页面上
  loadListPageDetailData:function(cs_id){
    LsRequest.get(`education/detail/selectByCourseId?cs_id=${cs_id}`).then(res=>{

      this.setData(
        {pageListDetailData : res.data}
      )
    })
  },
  loadPinglunData:function(cs_id){
   
    LsRequest.get(`education/comment/getAllRecommend?cs_id=${cs_id}`).then(res=>{
if(res.data.length ===0){
this.setData({noMore:true})
}
      this.setData({pinglun:res.data})
    })
  },
  handleInput(e){
    console.log(e.detail);
   
    this.setData({inputPingLun:e.detail})
    

  },

  handleSendBtnClick:function(){
    const user_id  = wx.getStorageSync('u_id')
    var that = this
   LsRequest.post(
     'education/comment/addComment',{
       cm_name:wx.getStorageSync('user').nickName,
       cm_desc:that.data.inputPingLun,
       course_id:that.data.courseId,
       user_id: user_id
     }
   ).then(res=>{
    
     if(res.data.code === "200"){
       console.log('aaaaaaaaaaaaaa');
       that.loadPinglunData(that.data.courseId);
      Toast.success('评论成功');
     }else{
      Toast.fail('评论失败');
     }
   })
   this.setData({inputPingLun:''})
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    console.log(options);
    this.setData({courseId:options.cs_id})
    this.loadListPageDetailData(options.cs_id)
    this.loadPinglunData(options.cs_id)
    this.setData({courseId:options.cs_id})
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
    // this.setData({num:this.data.num+1})
    // this.loadPinglunData(this.data.courseId,this.data.num)
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {


  }
})