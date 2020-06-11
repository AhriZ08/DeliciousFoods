<template>
	<view class="container">
		<view class="uni-list">
			<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(item,index) in news" :key="index" @tap="openinfo(item.post_id)" >
				<view class="uni-media-list">
					<image class="uni-media-list-logo" :src="item.author_avatar"></image>
					<view class="uni-media-list-body">
						<view class="uni-media-list-text-top">{{item.title}}</view>
						<view class="uni-media-list-text-bottom uni-ellipsis">{{item.created_at}}</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				news:[]
			}
		},
		methods: {
			openinfo(e) {
					uni.navigateTo({
					url: 'news_t?newsid='+e
				});
			}
		},
		onLoad:function(){
			uni.request({
				url: 'http://unidemo.dcloud.net.cn/api/news',
				method: 'GET',
				data: {},
				success: res => {
					// console.log(res);
					this.news = res.data;
				},
				fail: () => {},
				complete: () => {}
			});
		}
	}
</script>

<style scoped>
	@import url("../../uni.css");
	.uni-media-list-body{
		height: auto;
	}
	.uni-media-list-text-top{
		line-height: 1.6em;
	}
</style>
