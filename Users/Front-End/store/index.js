// Vuex状态管理
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	// 数据源
	state:{
		historyList:[
			
		],
	},
	mutations:{
		SET_HISTORY_LIST(state,history){
			state.historyList = history
		}
	},
	actions:{
		set_history({commit,state},history){
			let list = state.historyList
			list.unshift(history)
			commit('SET_HISTORY_LIST',list)
		},
		clean_history({commit,state}){
			let list = []
			commit('SET_HISTORY_LIST',list)
		},
	}
})

export default store