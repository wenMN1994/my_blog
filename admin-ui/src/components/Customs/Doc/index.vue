<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'CustomsDoc',
  data() {
    return {
      url: 'https://github.com/wenMN1994'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>