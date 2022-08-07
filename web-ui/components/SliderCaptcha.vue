<template>
  <div id="slideVerify" class="slide-verify" :style="widthlable" onselectstart="return false;">
    <canvas ref="canvas" :width="bigImageWidth" :height="bigImageHeight" />
    <canvas ref="block" class="slide-verify-block" :width="bigImageWidth" :height="bigImageHeight" />
    <div class="slide-verify-refresh-icon el-icon-refresh" @click="refresh" />
    <div class="slide-verify-info" :class="{fail: fail, show: showInfo}" @click="refresh">{{ infoText }}</div>
    <div
      class="slide-verify-slider"
      :style="widthlable"
      :class="{'container-active': containerActive, 'container-success': containerSuccess, 'container-fail': containerFail}"
    >
      <div class="slide-verify-slider-mask" :style="{width: sliderMaskWidth}">
        <div
          class="slide-verify-slider-mask-item"
          :style="{left: sliderLeft}"
          @mousedown="sliderDown"
          @touchstart="touchStartEvent"
          @touchmove="touchMoveEvent"
          @touchend="touchEndEvent"
        >
          <div class="slide-verify-slider-mask-item-icon el-icon-s-unfold" />
        </div>
      </div>
      <span class="slide-verify-slider-text">{{ sliderText }}</span>
    </div>
  </div>
</template>

<script>
function sum(x, y) {
  return x + y
}

function square(x) {
  return x * x
}
export default {
  name: 'SliderCaptcha',
  props: {
    l: {
      type: Number,
      default: 42
    },
    r: {
      type: Number,
      default: 10
    },
    bigImageWidth: { // 背景图宽
      type: [Number, String],
      default: 350
    },
    bigImageHeight: { // 背景图高
      type: [Number, String],
      default: 200
    },
    smallImageWidth: { // 小图宽
      type: [Number, String],
      default: 50
    },
    smallImageHeight: { // 小图高
      type: [Number, String],
      default: 50
    },
    yHeight: { // 小图初始的垂直距离
      type: [Number, String],
      default: 20
    },
    sliderText: {
      type: String,
      default: 'Slide filled right'
    },
    bigImage: { // 大图地址
      type: String,
      default: ''
    },
    smallImage: { // 小图地址
      type: String,
      default: ''
    },
    fresh: {
      type: Boolean,
      default: false
    }
  },

  data() {
    return {
      containerActive: false, // container active class
      containerSuccess: false, // container success class
      containerFail: false, // container fail class
      canvasCtx: null,
      blockCtx: null,
      block: null,
      canvasStr: null,
      L: this.l + this.r * 2 + 3, // block real lenght
      img: undefined,
      originX: undefined,
      originY: undefined,
      isMouseDown: false,
      trail: [],
      widthlable: '',
      sliderLeft: 0, // block right offset
      sliderMaskWidth: 0, // mask width
      dialogVisible: false,
      infoText: '验证成功',
      fail: false,
      showInfo: false
    }
  },
  watch: {
    fresh(val) {
      if (val) {
        this.init()
      }
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.initDom()
      this.bindEvents()
      this.widthlable = 'width:' + this.bigImageWidth + 'px;'
    },
    initDom() {
      this.block = this.$refs.block
      this.canvasStr = this.$refs.canvas

      this.canvasCtx = this.canvasStr.getContext('2d')
      this.blockCtx = this.block.getContext('2d')
      this.initImg()
    },
    initImg(bigImageHeight) {
      var that = this
      const img = document.createElement('img')
      img.onload = onload
      img.onerror = () => {
        img.src = that.bigImage
      }
      img.src = that.bigImage
      img.onload = function() {
        that.canvasCtx.drawImage(img, 0, 0, that.bigImageWidth, that.bigImageHeight)
      }

      this.img = img
      const img1 = document.createElement('img')
      var blockCtx = that.blockCtx
      var yHeight = bigImageHeight || that.yHeight
      if (yHeight === 0) {
        return
      }
      img1.onerror = () => {
        img1.src = that.smallImage
      }
      img1.src = that.smallImage
      img1.onload = function() {
        blockCtx.drawImage(img1, 0, yHeight, 55, 45)
      }
    },
    // 刷新
    refresh() {
      this.$emit('refresh')
    },
    sliderDown(event) {
      this.originX = event.clientX
      this.originY = event.clientY
      this.isMouseDown = true
    },
    touchStartEvent(e) {
      this.originX = e.changedTouches[0].pageX
      this.originY = e.changedTouches[0].pageY
      this.isMouseDown = true
    },
    bindEvents() {
      document.addEventListener('mousemove', e => {
        if (!this.isMouseDown) return false
        const moveX = e.clientX - this.originX
        const moveY = e.clientY - this.originY
        if (moveX < 0 || moveX + 38 >= this.bigImageWidth) return false
        this.sliderLeft = moveX + 'px'
        const blockLeft = ((this.bigImageWidth - 40 - 20) / (this.bigImageWidth - 40)) * moveX
        this.block.style.left = blockLeft + 'px'
        this.containerActive = true // add active
        this.sliderMaskWidth = moveX + 'px'
        this.trail.push(moveY)
      })
      document.addEventListener('mouseup', e => {
        if (!this.isMouseDown) return false
        this.isMouseDown = false
        if (e.clientX === this.originX) return false
        this.containerActive = false // remove active
        this.verify()
      })
    },
    touchMoveEvent(e) {
      if (!this.isMouseDown) return false
      const moveX = e.changedTouches[0].pageX - this.originX
      const moveY = e.changedTouches[0].pageY - this.originY
      if (moveX < 0 || moveX + 38 >= this.bigImageWidth) return false
      this.sliderLeft = moveX + 'px'
      const blockLeft = ((this.bigImageWidth - 40 - 20) / (this.bigImageWidth - 40)) * moveX
      this.block.style.left = blockLeft + 'px'

      this.containerActive = true
      this.sliderMaskWidth = moveX + 'px'
      this.trail.push(moveY)
    },
    touchEndEvent(e) {
      if (!this.isMouseDown) return false
      this.isMouseDown = false
      if (e.changedTouches[0].pageX === this.originX) return false
      this.containerActive = false
      this.verify()
    },
    verify() {
      const arr = this.trail // drag y move distance
      const average = arr.reduce(sum) / arr.length // average
      const deviations = arr.map(x => x - average) // deviation array
      const stddev = Math.sqrt(deviations.map(square).reduce(sum) / arr.length) // standard deviation
      const left = parseInt(this.block.style.left)
      this.$emit('success', left, stddev)
    },
    reset(bigImageHeight) {
      this.containerActive = false
      this.containerSuccess = false
      this.containerFail = false
      this.sliderLeft = 0
      this.block.style.left = 0
      this.sliderMaskWidth = 0
      this.canvasCtx.clearRect(0, 0, this.bigImageWidth, this.bigImageHeight)
      this.blockCtx.clearRect(0, 0, this.bigImageWidth, this.bigImageHeight)
      this.fail = false
      this.showInfo = false
      this.containerFail = false
      this.containerSuccess = false
      this.initImg(bigImageHeight)
    },
    handleFail() {
      this.fail = true
      this.showInfo = true
      this.infoText = '验证失败'
      this.containerFail = true
    },
    handleSuccess() {
      this.showInfo = true
      this.infoText = '验证成功'
      this.containerSuccess = true
      setTimeout(() => {
        this.block.style.left = 0
        this.sliderMaskWidth = 0
        this.sliderLeft = 0
        this.fail = false
        this.showInfo = false
        this.containerSuccess = false
      }, 1000)
    }
  }
}
</script>
