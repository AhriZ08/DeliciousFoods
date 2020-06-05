<template>
	<view class="tt">
		<!-- 文字 -->
		<view style="text-align: center;border-bottom: 1rpx #888888 solid; ">
			<text style="font-size: 70rpx;color: #a5b1c2;">推荐店铺</text>
		</view>
		<!-- 店铺块 -->
		<shopt  v-for="(item,index) in 10":key =index></shopt>
	</view>
</template>

<script>
	import shopt from '../shop-t.vue'
	export default {
		data() {
			return {
				
			};
		},
		methods:{

		},
		components:{
			shopt
		}
	}
</script>

<style lang="scss">
	.tt{margin-top: 10rpx;}

</style>
