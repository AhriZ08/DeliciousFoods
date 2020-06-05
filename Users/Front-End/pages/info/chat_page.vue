<template>
	<view>
		<!-- 时间块 -->
		<view class="chat_time">
			<text>{{Ctime}}</text>
		</view>
		<!-- 聊天块 -->
		<view class="chat_info">
			<Chatitem :value="item" v-for="item in chat_mesg"></Chatitem>
		</view>
		<!-- 输入框 -->
		<view class="input_part">
			<input :value="Svalue" class="input_info" @input="changevalue"/>
			<button  class="input_button" size="mini" @click="emitmes">发送</button>
		</view>
	</view>
</template>

<script>
	import Chatitem from '../../components/uni-deli/chat_item.vue'
	export default {
		data() {
			return {
				chat_mesg:[],
				Svalue:"",
				Ctime:""
			};
		},
		methods:{
			changevalue(e){
				this.Svalue = e.detail.value
			},
			emitmes(){
				this.chat_mesg.push(this.Svalue)
				this.Svalue = ""
			},
			// 获取当前时间函数
			GetTime(){
				        var date = new Date();
						
						var year = date.getFullYear();        //年 ,从 Date 对象以四位数字返回年份
						var month = date.getMonth() + 1;      //月 ,从 Date 对象返回月份 (0 ~ 11) ,date.getMonth()比实际月份少 1 个月
						var day = date.getDate();             //日 ,从 Date 对象返回一个月中的某一天 (1 ~ 31)
						
						var hours = date.getHours();          //小时 ,返回 Date 对象的小时 (0 ~ 23)
						var minutes = date.getMinutes();      //分钟 ,返回 Date 对象的分钟 (0 ~ 59)
						var seconds = date.getSeconds();      //秒 ,返回 Date 对象的秒数 (0 ~ 59)   
						//修改月份格式
						if (month >= 1 && month <= 9) {
					        month = "0" + month;
					        }
						
						//修改日期格式
						if (day >= 0 && day <= 9) {
					        day = "0" + day;
					        }
						
						//修改小时格式
						if (hours >= 0 && hours <= 9) {
					        hours = "0" + hours;
					        }
						
						//修改分钟格式
						if (minutes >= 0 && minutes <= 9) {
					        minutes = "0" + minutes;
					        }
						
						//修改秒格式
						if (seconds >= 0 && seconds <= 9) {
					        seconds = "0" + seconds;
					        }
						
						//获取当前系统时间  格式(yyyy-mm-dd hh:mm:ss)
						var Curtime = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
						return Curtime
					}
		},
		components:{
			Chatitem
		},
		onLoad() {
			this.Ctime = this.GetTime()
		}
	}
</script>

<style lang="scss">
	.chat_time{
		display: flex;
		justify-content: center;
		align-items: center;
		color: #718093;
		font-size: 25rpx;
		padding: 10rpx 0;
	}
	.chat_info{}
	.input_part{
		width: 100%;
		height: 120rpx;
		position: fixed;
		bottom: 0;
		left: 0;
		right: 0;
		border-top: 1px #EEEEEE solid;
		padding: 10rpx 6rpx;
		display: flex;
		justify-content: space-between;
		align-items: center;
		.input_info{
			width: 530rpx;
			background-color: #f5f6fa;
			color: #718093;
			border-radius: 20rpx;
			font-size: 35rpx;
			margin-left: 20rpx;
			padding: 10rpx 20rpx;
		}
		.input_button{
			margin-left: 10rpx;
			margin-right: 20rpx;
		}
	}
</style>
