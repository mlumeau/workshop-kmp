//
//  MainViewModel.swift
//  kosmos
//
//  Created by Robin Caroff on 13/08/2019.
//  Copyright © 2019 Maxime Lumeau. All rights reserved.
//

import Foundation
import kore

final class MainViewModel {
    private let apodRepository: APODRepositoryRemote = APODRepositoryRemoteImpl()
    var apod: APOD? = nil
    var onAPODLoaded: ((APOD) -> ())? = nil
    var onLoadingError: (() -> ())? = nil
    
    init() {
        startLoadingData()
    }
    
    private func startLoadingData() {
        apodRepository.getAPOD(completion: { apod in
            self.apod = apod
            self.onAPODLoaded?(apod)
            return .init()
        }, failure: { () in
            self.onLoadingError?()
            return .init()
        })
    }
}
