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

    @IBOutlet weak var apodIV: UIImageView!
    @IBOutlet weak var titleTV: UITextView!
    @IBOutlet weak var descTV: UITextView!
    @IBOutlet weak var progress: UIActivityIndicatorView!
    
    private let apodRepository: APODRepositoryCache = APODRepositoryCacheImpl()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        startLoadingData()
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return self.style
    }
    var style:UIStatusBarStyle = .default

}

private extension MainViewController {
    
    private func startLoadingData() {
        apodRepository.getAPOD(completion: { apod in
            self.updateAPODData(apod: apod)
        }, failure: { () in
            self.onLoadingError()
        })
    }
    
    func updateAPODData(apod: APOD) {
        self.progress.isHidden = true
        
        titleTV.text = apod.title
        descTV.text = apod.explanation
        
        if(apod.media_type == "image") {
            if let imageURL = apod.url, let url = URL(string: imageURL) {
                Nuke.loadImage(with: url, into: self.apodIV)
            }
        } else {
            apodIV.removeFromSuperview()
        }
    }
    
    func onLoadingError() {}
}




