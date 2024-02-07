<template>
  <div>
    <!-- <h1>{{ message }}</h1> -->
    <!-- <element-view></element-view> -->
    <!-- <emp-view></emp-view> -->
    <router-view></router-view>
  </div>
</template>
<script>
// import ElementView from './views/element/ElementView.vue'
// import EmpView from './views/tlias/EmpView.vue'
export default{
  // components:{ElementView},
  // components:{EmpView},
  data() {
    return {
      message:"Vue2"
    }
  },
  methods:{

  }
}
</script>

<style>

</style>
