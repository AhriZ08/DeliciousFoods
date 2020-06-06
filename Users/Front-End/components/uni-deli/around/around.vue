<template>
	<view class="tt">
		<!-- 文字 -->
		<view style="text-align: center;border-bottom: 1rpx #888888 solid; ">
			<text style="font-size: 70rpx;color: #a5b1c2;">推荐店铺</text>
		</view>
		<!-- 店铺块 -->
		<shopt  v-for="(item,index) in shops":key =index :shoptl=item class="111"></shopt>
	</view>
</template>

<script>
	import shopt from '../shop-t.vue'
	export default {
		data() {
			return {
				shops:[]
			};
		},
		methods:{
			
		},
		components:{
			shopt
		},
		mounted() {
			uni.request({
				url:'http://47.112.243.221:8080/dFoods/sp/recommend',
				success: (e) => {
					this.shops = e.data
					console.log(this.shops)
				},
				fail(e) {
					console.log(e);
				}
			})
		}	
		
		
	}
</script>

<style lang="scss">
	.tt{margin-top: 10rpx;}

</style>
