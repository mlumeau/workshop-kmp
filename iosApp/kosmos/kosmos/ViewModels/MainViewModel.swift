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
    private let getConnectionState: GetConnectionState = GetConnectionStateIos()
    private let getApodUseCase: GetAPOD
    var apod: APOD? = nil
    var onAPODLoaded: ((APOD) -> ())? = nil
    var onLoadingError: (() -> ())? = nil
    
    init() {
        getApodUseCase = GetAPODImpl(getConnectionState: getConnectionState)
        startLoadingData()
    }
    
    private func startLoadingData() {
        getApodUseCase.getAPOD(completion: { apod in
            self.apod = apod
            self.onAPODLoaded?(apod)
        }, failure: { () in
            self.onLoadingError?()
        })
    }
}
