<template>
  <div id="app">
    <file v-bind:input-id="'video-upload'"
          v-bind:text="'上传'"
          v-bind:suffixs="['mp4', 'jpg', 'png']"
          v-bind:after-upload="afterUpload"></file>
    <div>
      <video width="320" height="240" controls>
        <source src="https://online-pilipili.oss-cn-guangzhou.aliyuncs.com/course/E6HnsQM5.mp4" type="video/mp4">
        您的浏览器不支持 video 标签。
      </video>
    </div>
  </div>

</template>

<script>
  import BigFile from '../components/big-file.vue'
  import File from '../components/file.vue'

  export default {
    name: 'test',
    components: {
      BigFile, File
    },
    data: function () {
      return {
        section: {},
        sections: [],
        SECTION_CHARGE: SECTION_CHARGE,
        FILE_USE: FILE_USE,
        course: {},
        chapter: {},
      }
    },
    mounted: function () {
      let _this = this;
    },

    methods: {
      afterUpload(resp) {
        let _this = this;
        let video = resp.content.path;
        _this.getTime();
        console.log(video)
      },

      /**
       * 获取时长
       */
      getTime() {
        let _this = this;
        setTimeout(function () {
          let ele = document.getElementById("video");
          _this.section.time = parseInt(ele.duration, 10);
        }, 1000);
      },
    },

  }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>