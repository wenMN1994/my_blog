<template>
  <div>
    <mavon-editor ref="md" :style="'height:' + height" @imgAdd="imgAdd" />
  </div>
</template>

<script>
import { uploadFilesToOss } from '@/utils/upload'
export default {
  name: 'Markdown',
  data() {
    return {
      uploadUrl: process.env.VUE_APP_BASE_API + "/common/uploadFilesToOss", // 上传的图片服务器地址
      height: document.documentElement.clientHeight - 200 + 'px'
    }
  },
  mounted() {
    const that = this
    window.onresize = function temp() {
      that.height = document.documentElement.clientHeight - 200 + 'px'
    }
  },
  methods: {
    imgAdd(pos, $file) {
      uploadFilesToOss(this.uploadUrl, $file).then(res => {
        debugger;
        const data = res.data
        const url = data.urls
        this.$refs.md.$img2Url(pos, url)
      })
    }
  }
}
</script>

<style scoped>
  .v-note-wrapper.shadow {
    z-index: 5;
  }
</style>
