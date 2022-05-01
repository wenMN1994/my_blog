<template>
  <div>
    <svg-icon icon-class="github" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'CustomsGit',
  data() {
    return {
      url: 'https://github.com/wenMN1994/my_blog'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>