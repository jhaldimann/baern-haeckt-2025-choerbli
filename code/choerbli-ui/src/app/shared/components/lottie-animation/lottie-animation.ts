import {Component, Input} from '@angular/core';
import {AnimationOptions, LottieComponent} from 'ngx-lottie';
import {AnimationItem} from 'lottie-web';

@Component({
  selector: 'app-lottie-animation',
  imports: [LottieComponent],
  templateUrl: './lottie-animation.html',
  styleUrl: './lottie-animation.scss'
})
export class LottieAnimation {
  private animationItem: AnimationItem | undefined;

  @Input() options: AnimationOptions = {
    path: '/assets/animations/congratulation.json',
    autoplay: true,
    loop: false,
  };

  animationCreated(animationItem: AnimationItem): void {
    this.animationItem = animationItem;
  }

  public play(): void {
    console.log('play')
    if (this.animationItem) {
      this.animationItem.play();
    }
  }

  public pause(): void {
    if (this.animationItem) {
      this.animationItem.pause();
    }
  }

  public stop(): void {
    if (this.animationItem) {
      this.animationItem.stop();
    }
  }
}
