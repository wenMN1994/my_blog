<template>
    <div>
      <div class="toc">
        <toc :toc="toc" class="toc"></toc>
      </div>
      <div class="markdown">
        <markdown-it :v-html="compiledMarkdown" class="markdown"></markdown-it>
      </div>
    </div>
  </template>
  
  <script>
  import MarkdownIt from 'markdown-it';
  import top from 'markdown-it-top';
  import 'prismjs';
  import 'prismjs/themes/prism.css';
  
  export default {
    name: 'MyMarkdown',
    components: {
        MarkdownIt,
        top
    },
    props: {
      initialContent: {
        type: String,
        default: ''
      }
    },
    data() {
      return {
        markdownContent: this.initialContent
      };
    },
    mounted() {
      this.updateMarkdownContent();
    },
    watch: {
      initialContent() {
        this.updateMarkdownContent();
      }
    },
    computed: {
      compiledMarkdown() {
        const md = new MarkdownIt({
          html: true,
          linkify: true,
          typographer: true
        });
        const tokens = md.parse(this.markdownContent || '', {});
        return md.renderer.render(tokens, md.options);
      },
      toc() {
        const md = new MarkdownIt();
        const tokens = md.parse(this.markdownContent || '', {});
        const headings = tokens.filter((token) => token.type === 'heading_open');
        return headings.map((heading) => ({
          level: Number(heading.tag.slice(1)),
          title: this.getTextInsideHeading(heading)
        }));
      }
    },
    methods: {
      updateMarkdownContent() {
        this.markdownContent = this.initialContent;
      },
      getTextInsideHeading(heading) {
        const textToken = heading.children.find((child) => child.type === 'inline');
        return textToken ? textToken.content : '';
      }
    }
  };
  </script>
  
  <style>
  .container {
    display: flex;
    justify-content: space-between;
  }
  
  .toc {
    flex: 0 0 20%;
    padding-right: 1rem;
  }
  
  .markdown {
    flex: 1;
  }
  
  .line-numbers-rows {
    border-right-color: #ccc;
  }
  
  .keyword {
    color: red;
  }
  </style>