<template>
	<view class="content">
		<view class="title">{{title}}</view>
		<view class="art-content">
			<rich-text :nodes="str"></rich-text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title:'',
				str:''
			}
		},
		onLoad:function(e){
			uni.showLoading({
				title: '加载中......',
				mask: false
			});
			console.log(e);
			uni.request({
				url: 'http://unidemo.dcloud.net.cn/api/news/36kr/'+e.newsid,
				method: 'GET',
				data: {},
				success: res => {
					this.title = res.data.title;
					this.str = res.data.content;
					uni.hideLoading();
				},
				fail: () => {},
				complete: () => {}
			});
		},
		methods: {
			
		}
	}
</script>

<style scoped>
	@import url("../../uni.css");
.content{
	padding: 10upx 2%;
	width: 96%;
	flex-wrap: wrap;
}
.title{
	line-height: 2em;
	font-weight: 700;
	font-size: 38upx;
	text-align: center;
}
.art-content{
	line-height: 2em;
}
</style>
