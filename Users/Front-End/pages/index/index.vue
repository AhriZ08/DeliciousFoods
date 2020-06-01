<template>
	<view class="main">
		<!-- 地图+搜索区 -->
		<Search></Search>
		<!-- 轮播图 -->
		<view class="scroll">
		<Swps></Swps>	
		</view>
		<!-- 分类区 -->
		<Sort></Sort>
		<!-- 推荐区 -->
		<view class="commend">
			<Around></Around>
		</view>
	</view>
</template>

<script>
	import Search from '../../components/uni-deli/search/search.vue'
	import Swps from '../../components/uni-deli/swps/swps.vue'
	import Around from '../../components/uni-deli/around/around.vue'
	import Sort from '../../components/uni-deli/sort.vue'
	export default {
		components:{
			Search,
			Swps,
			Around,
			Sort
		},
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style lang="scss" scoped>
	.main{margin: 0 10rpx;}
	.map{
		width: 750rpx;
		height: 100rpx;
		border: #333333 2rpx solid;
	}
	.serch{
	}

	.sort{
	}
	.commend{
	}
</style>
