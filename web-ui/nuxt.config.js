module.exports = {
  env: {
    // 对应package.json及request.js
    BASE_URL: process.env.BASE_URL,
    // 对应环境production、test等
    NODE_ENV: process.env.NODE_ENV
  },
  // 本地服务启动yarn dev的端口号
  server: {
      port: 3000
  },
  // 必须引入，不然无法使用axios跟代理
  modules: [
    '@nuxtjs/axios',
    '@nuxtjs/proxy',
    '@nuxtjs/markdownit'
  ],
  axios: {
    proxy: true, // 开启代理
    prefix: process.env.BASE_URL, // baseURL
    baseURL: '',
    withCredentials: true,
    credentials: true,
  },
  // 配置反向代理，记得使用的时候需要带上/prod-api
  // 下面举了例子可以参考一下
  // 但是配置了env环境，根本用不上proxy代理的
  // 例如：https://dragonwen.cn/prod-api/xxx/xxx
  proxy: {
    [process.env.BASE_URL]: {
      target: 'http://localhost:8080',
      changeOrigin: true, // 表示是否跨域
      pathRewrite: {
        ['^' + process.env.BASE_URL]: ''
      },
      secure: true
    }
  },
  markdownit: {
    preset: 'default',
    linkify: true,
    breaks: true,
    use: [
      'markdown-it-toc', // 自动生成目录插件
      ['markdown-it-prism', {
        plugins: [
          'line-numbers', // 代码行号插件
          'highlight-keywords' // 代码高亮关键字插件
        ]
      }]
    ]
  },

  // some nuxt config...
  vender:[
    'element-ui', 'axios'
  ],
  css: [
    'element-ui/lib/theme-chalk/index.css',
    '~node_modules/swiper/swiper-bundle.css'
  ],

  plugins: [
    { src: '~/plugins/nuxt-plugin', ssr: false},
    { src: '~/plugins/element-ui', ssr: true },
  ],

  /*
	 ** Headers of the page
	 */
  head: {
    title: '龙颜问世',
    meta: [{
      charset: 'utf-8'
    },
    {
      name: 'viewport',
      content: 'width=device-width, initial-scale=1'
    },
    {
      hid: 'keywords',
      name: 'keywords',
      content: '龙颜问世'
    },
    {
      hid: 'description',
      name: 'description',
      content: '龙颜问世'
    }
    ],
    link: [{
      rel: 'icon',
      type: 'image/x-icon',
      href: '/favicon.ico'
    }]
  },

  /*
	 ** Customize the progress bar color
	 */
  loading: {
    color: '#3B8070'
  },
  /*
	 ** Build configuration
	 */
  build: {
    /*
		 ** Run ESLint on save
		 */
    extend(config, {
      isDev,
      isClient
    }) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/
        })
      }
    }
  }
}
