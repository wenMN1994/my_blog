<template>
  <div id="app-container">
    <my-markdown :initial-content="markdownContent"></my-markdown>
  </div>
</template>

<script>
import MyMarkdown from '~/components/myMarkdown.vue';
import articleApi from '@/api/article'

export default {
  components: {
    MyMarkdown
  },
  data() {
    return {
      markdownContent: ''
    };
  },
  async mounted() {
    await this.getArticleInfo();
  },
  methods: {
    async getArticleInfo() {
      let queryParams = {
        articleId: 2
      }
      articleApi.getArticleInfo(queryParams).then(response => {
        console.log(response.data.data.content);
        this.markdownContent = response.data.data.content;
      })
    }
  }
};
</script>