<template>
  <div class="wrapper">
    <div style="margin: 40px 0;padding:40px;">
      本系统是一个在线办公系统,适合中小企业的办公使用
    </div>
  </div>
</template>

<script>
export default {
  name: "FrontHome",
  data() {
    return {
      imgs: [
          '../assets/404.png',
          'https://img13.360buyimg.com/babel/s1580x830_jfs/t1/96398/30/23715/70228/6221e9d0Ec1b9fe65/f66e2ad76314d6cd.jpg!cc_1580x830.webp'
      ],
      files: []
    }
  },
  created() {
    this.request.get("/echarts/file/front/all").then(res => {
      console.log(res.data)
      this.files = res.data.filter(v => v.type === 'png' || v.type === 'jpg' || v.type === 'webp')
    })
  },
  methods: {

  }
}
</script>

<style scoped>
.wrapper {
  background: url("../../assets/home.png");
  width: 60%;
  height: 80%;
  position: fixed;
  background-size: 100% 100%;
}
</style>
