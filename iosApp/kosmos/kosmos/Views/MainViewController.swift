//
//  ViewController.swift
//  kosmos
//
//  Created by Maxime Lumeau on 13/03/2019.
//  Copyright © 2019 Maxime Lumeau. All rights reserved.
//

import UIKit
import Nuke
import kore

class MainViewController: UIViewController {
    
    let viewModel = MainViewModel()

    @IBOutlet weak var apodIV: UIImageView!
    @IBOutlet weak var titleTV: UITextView!
    @IBOutlet weak var descTV: UITextView!
    @IBOutlet weak var progress: UIActivityIndicatorView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configureUI()
        configureBinding()
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return self.style
    }
    var style:UIStatusBarStyle = .default

}

private extension MainViewController {
    
    func configureUI() {
    }
    
    func configureBinding() {
        viewModel.onAPODLoaded = updateAPODData
        viewModel.onLoadingError = onLoadingError
    }
    
    func updateAPODData(apod: APOD) {
        let url = URL(string: apod.url ?? "")
        if(apod.media_type == "image" && apod.title?.isEmpty != true){
            Nuke.loadImage(with: url!, into: self.apodIV)
            self.titleTV.text = apod.title
            self.descTV.text = apod.explanation
        }else{
            self.titleTV.text = "Sorry, no picture today :("
        }
        self.progress.isHidden = true
    }
    
    func onLoadingError() {}
}




