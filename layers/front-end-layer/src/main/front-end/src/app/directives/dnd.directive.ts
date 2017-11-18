import {Directive, ElementRef, EventEmitter, HostBinding, HostListener, Input, Output, Renderer2} from '@angular/core';
import {DomSanitizer, SafeStyle} from '@angular/platform-browser';


@Directive({
  selector: '[appDnd]'
})
export class DndDirective {
  @Input() private allowedExtensions: Array<string> = [];
  @Input() private limit: Number = 10;
  @Input() private minSize: Number = 1000;
  @Input() private maxSize: Number = 5 * 1000000;
  @Input() private dropAcceptMultiple: Boolean = false;
  @Output() private filesChangeEmiter: EventEmitter<File[]> = new EventEmitter();
  @Output() private filesInvalidEmiter: EventEmitter<File[]> = new EventEmitter();
  @Output() private fileAcceptedEmiter: EventEmitter<File> = new EventEmitter();
  @HostBinding('style.background-color') private backgroundColor: SafeStyle = '#eee';
  @HostBinding('style.background-image') private backgroundImage: SafeStyle = '';
  @HostBinding('style.background-size') private backgroundSize: SafeStyle = 'contain';
  @HostBinding('style.background-repeat') private backgroundRepeat: SafeStyle = 'no-repeat';

  constructor(private sanitizer: DomSanitizer, private renderer: Renderer2, private el: ElementRef) { }

  @HostListener('dragover', ['$event']) public onDragOver(evt) {
    evt.preventDefault();
    evt.stopPropagation();
    this.backgroundColor = '#999';
  }

  @HostListener('dragleave', ['$event']) public onDragLeave(evt) {
    evt.preventDefault();
    evt.stopPropagation();
    this.backgroundColor = '#eee';
  }

  @HostListener('drop', ['$event']) public onDrop(evt) {
    evt.preventDefault();
    evt.stopPropagation();
    this.backgroundColor = '#eee';
    const files = evt.dataTransfer.files;
    const validFiles: Array<File> = [];
    const invalidFiles: Array<File> = [];
    if (files.length > 0) {
      Array.prototype.slice.call(files, 0, this.limit);
      for (const file of files) {
          const ext = file.name.split('.')[file.name.split('.').length - 1];
          if (this.allowedExtensions.lastIndexOf(ext) !== -1
              && this.minSize <= file.size
              && this.maxSize >= file.size) {
            validFiles.push(file);
          } else {
            invalidFiles.push(file);
          }
      }
      if (this.dropAcceptMultiple) {
        this.filesChangeEmiter.emit(validFiles);
        this.filesInvalidEmiter.emit(invalidFiles);
      } else {
        const f: File = files[0];
        this.onLoadFile(f);
        this.makeAttachedFile(f);
        this.fileAcceptedEmiter.emit(f);
      }
    }
  }

  onLoadFile(file: File) {
    const reader = new FileReader();
    const self = this;
    reader.onload = (event: Event) => {
      self.backgroundImage = self.sanitizer.bypassSecurityTrustStyle(
        'url(' + reader.result + ')'
      );
    };
    reader.readAsDataURL(file);
  }

  makeAttachedFile(file: File) {
    const parent = this.el.nativeElement.parentNode;
    const spElement = this.renderer.createElement('span');
    const fileName = this.renderer.createText(file.name);
    const btnElement = this.renderer.createElement('button');
    const iElement = this.renderer.createElement('i');

    this.renderer.addClass(btnElement, 'btn');
    this.renderer.addClass(btnElement, 'btn-danger');
    this.renderer.addClass(iElement, 'fa');
    this.renderer.addClass(iElement, 'fa-times');

    this.renderer.appendChild(btnElement, iElement);
    this.renderer.appendChild(spElement, fileName);
    this.renderer.appendChild(spElement, btnElement);
    this.renderer.insertBefore(parent, spElement, spElement.nativeElement);

    const self = this;
    this.renderer.listen(btnElement, 'click', (event) => {
      self.renderer.removeChild(parent, spElement);
      self.backgroundImage = '';
      self.fileAcceptedEmiter.emit(null);
    });
  }
}
