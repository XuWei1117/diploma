// pages/search/index.js
import LsRequest from '../../service/index'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchData:'',
    cardData:[],
    historyData:[]
  },
  onSearch:function(e){ 
    var that = this
    LsRequest.get(
      `education/course/search?condition=${this.data.searchData}`
    ).then(res=>{
      this.setData({
        cardData:res.data
      })
    }
    )
    // console.log(this.data.searchData);
    // var historyData = this.data.historyData.concat(this.data.searchData)
    this.setData({
     historyData:this.data.historyData.concat(this.data.searchData).reverse()
    })


    if(this.data.searchData){
      var localHis = wx.getStorageSync("HISTORY_DATA")
      if(!localHis.includes(this.data.searchData)){
        wx.setStorageSync('HISTORY_DATA', this.data.historyData)
      }else{
        var index =localHis.indexOf(this.data.searchData)
        localHis.splice(index, 1)
        localHis.unshift(this.data.searchData)
        wx.setStorageSync('HISTORY_DATA',localHis)
      }
    }

  },
  onChange:function(e){
    this.setData({
      searchData:e.detail
    })
  },
  deleteHistoryData:function(e){
 
    var index = e.currentTarget.dataset.index
    var historyArr =this.data.historyData
    historyArr.splice(index,1)
        console.log(historyArr);
    this.setData({
      historyData:historyArr
    })
    wx.setStorageSync('HISTORY_DATA', historyArr)

  },
  showCourse:function(e){
    // console.log(e);
    const id = e.currentTarget.dataset.c_id
    wx.navigateTo({
      url:`/pages/list-detail/index?cs_id=${id}`

    })
    // LsRequest.get(`education/detail/selectByCourseId?cs_id=${id}`).then(res=>{
    //   console.log(res);
    // })
  },
  handleHistoryData:function(e){
  var name  = e.currentTarget.dataset.name
  LsRequest.get(`education/course/search?condition=${name}`).then(res=>{
    this.setData({
      cardData:res.data
    })
  })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
    var tmpData = wx.getStorageSync('HISTORY_DATA')
    this.setData({
      historyData:tmpData||[]
    })
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